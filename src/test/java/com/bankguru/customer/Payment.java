package com.bankguru.customer;

import org.testng.annotations.Test;

import com.bankguru.base.BaseTest;
import com.bankguru.data.Data;
import com.bankguru.pages.BalanceEnquiryPage;
import com.bankguru.pages.DeleteAccountPage;
import com.bankguru.pages.DeleteCustomerPage;
import com.bankguru.pages.DepositPage;
import com.bankguru.pages.EditAccountPage;
import com.bankguru.pages.EditCustomerPage;
import com.bankguru.pages.FundTransferPage;
import com.bankguru.pages.NewAccountPage;
import com.bankguru.pages.WithdrawPage;

public class Payment extends BaseTest {

	@Test
	public void Payment03_CreateNewAccountAndDeposit() {
		newAccountPage = homePage.clickToNewAccountLink();
		newAccountPage.typeDataToCustomerIdTextBox(Data.CustomerIdValue);
		newAccountPage.selectValueInAccountTypeList(Savings);
		newAccountPage.typeDataToInitialDepositTextBox(_50000_Savings);
		newAccountPage.clickSubmitButton();

		verifyTrue(newAccountPage.isNewAccountSuccessMessageDisplayed());

		verifyEquals(newAccountPage.getNewAccountSuccessMessage(), Data.AccountGeneratedSuccess);
		verifyEquals(newAccountPage.getCustomerIdValueAfterCreateAccount(), Data.CustomerIdValue);
		verifyEquals(newAccountPage.getAccountTypeValueAfterCreateAccount(), Savings);
		verifyEquals(newAccountPage.getCurrentAmountValueAfterCreateAccount(), _50000_Savings);

		Data.AccountIdValue_1 = newAccountPage.getAccountIdValueAfterCreateAccount();

		newAccountPage.clickToNewAccountLink();
		newAccountPage.typeDataToCustomerIdTextBox(Data.CustomerIdValue);
		newAccountPage.selectValueInAccountTypeList(Savings);
		newAccountPage.typeDataToInitialDepositTextBox(_50000_Savings);
		newAccountPage.clickSubmitButton();

		verifyTrue(newAccountPage.isNewAccountSuccessMessageDisplayed());

		verifyEquals(newAccountPage.getNewAccountSuccessMessage(), Data.AccountGeneratedSuccess);
		verifyEquals(newAccountPage.getCustomerIdValueAfterCreateAccount(), Data.CustomerIdValue);
		verifyEquals(newAccountPage.getAccountTypeValueAfterCreateAccount(), Savings);
		verifyEquals(newAccountPage.getCurrentAmountValueAfterCreateAccount(), _50000_Savings);

		Data.AccountIdValue_2 = newAccountPage.getAccountIdValueAfterCreateAccount();
	}

	@Test
	public void Payment04_EditAccountAndChangeAccountTypeToCurrent() {
		editAccountPage = newAccountPage.clickToEditAccountLink();
		editAccountPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_1);
		editAccountPage.clickSubmitButton();
		editAccountPage.selectValueInAccountTypeList(Current);
		editAccountPage.clickSubmitButton();

		verifyTrue(editAccountPage.isEditAccountSuccessMessageDisplayed());

		verifyEquals(editAccountPage.getEditAccountSuccessMessage(), Data.AccountDetailUpdatedSuccess);
		verifyEquals(editAccountPage.getAccountTypeValueAfterEditAccount(), Current);
	}

	@Test
	public void Payment05_TransferMoneyIntoCurrentAccount() {
		depositPage = editAccountPage.clickToDepositLink();
		depositPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_1);
		depositPage.typeDataToAmountTextBox(_5000_TransferIntoCurrentAcc);
		depositPage.typeDataToDescriptionTextBox(DescriptionDeposit);
		depositPage.clickSubmitButton();

		verifyTrue(depositPage.isDepositSuccessMessageDisplayed());

		verifyEquals(depositPage.getDepositSuccessMessage(), Data.TransactionDetailsOfDepositForAccount + Data.AccountIdValue_1);
		verifyEquals(depositPage.getDescriptionValueAfterDeposit(), DescriptionDeposit);
		verifyEquals(depositPage.getCurrentBalanceValueAfterDeposit(), TotalAfterDeposit);
	}

	@Test
	public void Payment06_WithdrawMoneyIntoCurrentAccount() {
		withdrawPage = depositPage.clickToWithdrawalLink();
		withdrawPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_1);
		withdrawPage.typeDataToAmountTextBox(_15000_Withdraw);
		withdrawPage.typeDataToDescriptionTextBox(DescriptionWithdraw);
		withdrawPage.clickSubmitButton();

		verifyTrue(withdrawPage.isWithdrawSuccessMessageDisplayed());

		verifyEquals(withdrawPage.getWithdrawSuccessMessage(), Data.TransactionDetailsOfWithdrawalForAccount + Data.AccountIdValue_1);
		verifyEquals(withdrawPage.getDescriptionValueAfterWithdraw(), DescriptionWithdraw);
		verifyEquals(withdrawPage.getCurrentBalanceValueAfterWithdraw(), TotalAfterWithdraw);
	}

	@Test
	public void Payment07_TrasnferMoneyIntoAnotherAccount() {
		fundTransferPage = withdrawPage.clickToFundTransferLink();
		fundTransferPage.typeDataToPayersAccountNumberTextBox(Data.AccountIdValue_1);
		fundTransferPage.typeDataToPayeesAccountNumberTextBox(Data.AccountIdValue_2);
		fundTransferPage.typeDataToAmountTextBox(_10000_TransferIntoAnotherAcc);
		fundTransferPage.typeDataToDescriptionTextBox(DescriptionTransfer);
		fundTransferPage.clickSubmitButton();

		verifyTrue(fundTransferPage.isTrasnferSuccessMessageDisplayed());

		verifyEquals(fundTransferPage.getTransferSuccessMessage(), Data.FundTransferDetails);
		verifyEquals(fundTransferPage.getFromAccountAfterTransfer(), Data.AccountIdValue_1);
		verifyEquals(fundTransferPage.getToAccountAfterTransfer(), Data.AccountIdValue_2);
		verifyEquals(fundTransferPage.getAmountAfterTransfer(), _10000_TransferIntoAnotherAcc);
		verifyEquals(fundTransferPage.getDescriptionAfterTransfer(), DescriptionTransfer);
	}

	@Test
	public void Payment08_CheckAccountPayerBalance() {
		balanceEnquiryPage = fundTransferPage.clickToBalanceEnquiryLink();
		balanceEnquiryPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_1);
		balanceEnquiryPage.clickSubmitButton();

		verifyTrue(balanceEnquiryPage.isBalanceEnquirySuccessMessageDisplayed());

		verifyEquals(balanceEnquiryPage.getBalanceEnquirySuccessMessage(), Data.BalanceDetailsForAccount + Data.AccountIdValue_1);
		verifyEquals(balanceEnquiryPage.getAccountNumberBalanceEnquiry(), Data.AccountIdValue_1);
		verifyEquals(balanceEnquiryPage.getBalanceEnquiry(), TotalBalance);
	}

	@Test
	public void Payment09_DeleteAccount() {
		// Account 1
		deleteAccountPage = balanceEnquiryPage.clickToDeleteAccountLink();

		deleteAccountPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_1);
		deleteAccountPage.clickSubmitButton();
		deleteAccountPage.clickAcceptAlert();

		verifyEquals(deleteAccountPage.getDeleteAccountSuccessMessage(), Data.AccountDeletedSuccessful);

		deleteAccountPage.clickAcceptAlert();

		editAccountPage = deleteAccountPage.clickToEditAccountLink();

		editAccountPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_1);
		editAccountPage.clickSubmitButton();

		verifyEquals(editAccountPage.getAccountNotExistMessage(), Data.AccountDoesNotExist);

		editAccountPage.clickAcceptAlert();

		// Account 2
		deleteAccountPage = editAccountPage.clickToDeleteAccountLink();

		deleteAccountPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_2);
		deleteAccountPage.clickSubmitButton();
		deleteAccountPage.clickAcceptAlert();

		verifyEquals(deleteAccountPage.getDeleteAccountSuccessMessage(), Data.AccountDeletedSuccessful);

		deleteAccountPage.clickAcceptAlert();

		editAccountPage = deleteAccountPage.clickToEditAccountLink();

		editAccountPage.typeDataToAccountNumberTextBox(Data.AccountIdValue_2);
		editAccountPage.clickSubmitButton();

		verifyEquals(editAccountPage.getAccountNotExistMessage(), Data.AccountDoesNotExist);

		editAccountPage.clickAcceptAlert();
	}

	@Test
	public void Payment10_DeleteCustomer() {
		deleteCustomerPage = editAccountPage.clickToDeleteCustomerLink();
		deleteCustomerPage.typeDataToCustomerIdTextBox(Data.CustomerIdValue);
		deleteCustomerPage.clickSubmitButton();
		deleteCustomerPage.clickAcceptAlert();
		verifyEquals(deleteCustomerPage.getDeleteCustomerSuccessMessage(), Data.CustomerDeletedSuccessful);
		deleteCustomerPage.clickAcceptAlert();

		editCustomerPage = deleteCustomerPage.clickToEditCustomerLink();
		editCustomerPage.typeDataToCustomerIdTextBox(Data.CustomerIdValue);
		editCustomerPage.clickSubmitButton();
		verifyEquals(editCustomerPage.getCustomerNotExistMessage(), Data.CustomerDoesNotExist);
		deleteCustomerPage.clickAcceptAlert();
	}

	private EditCustomerPage editCustomerPage;
	private DeleteCustomerPage deleteCustomerPage;
	private NewAccountPage newAccountPage;
	private EditAccountPage editAccountPage;
	private DeleteAccountPage deleteAccountPage;
	private FundTransferPage fundTransferPage;
	private BalanceEnquiryPage balanceEnquiryPage;
	private DepositPage depositPage;
	private WithdrawPage withdrawPage;
	private String Savings = "Savings";
	private String Current = "Current";
	private String _50000_Savings = "50000";
	private String _15000_Withdraw = "15000";
	private String _10000_TransferIntoAnotherAcc = "10000";
	private String _5000_TransferIntoCurrentAcc = "5000";
	private String TotalAfterDeposit = String.valueOf(Integer.parseInt(_50000_Savings) + Integer.parseInt(_5000_TransferIntoCurrentAcc));
	private String TotalAfterWithdraw = String.valueOf(Integer.parseInt(TotalAfterDeposit) - Integer.parseInt(_15000_Withdraw));
	private String TotalBalance = String.valueOf(Integer.parseInt(TotalAfterWithdraw) - Integer.parseInt(_10000_TransferIntoAnotherAcc));
	private String DescriptionDeposit = "deposit";
	private String DescriptionWithdraw = "withdraw";
	private String DescriptionTransfer = "transfer";
}
