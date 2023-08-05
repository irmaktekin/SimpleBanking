package com.eteration.simplebanking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import javax.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.eteration.simplebanking.dto.AccountDto;
import com.eteration.simplebanking.model.Amount;
import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.services.AccountService;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
	
		@InjectMocks
		private AccountController accountController;
		
		@Mock
		private AccountService accountService;
		
		@Mock
		private AccountRepository accountRepository;
		
		@Test
		void testGetAccountById_shouldReturnAccount() throws Exception {
			 ResponseEntity<BankAccount> accountById = accountController.getAccountById(1L);
			 assertEquals(HttpStatus.valueOf(200),accountById.getStatusCode());
			 verify(accountService,times(1)).findById(1L);
		}
	
		
		@Test
		public void testCredit_thenReturnJson()throws Exception {
		        
		     BankAccount account = new BankAccount("Irmak Tekin", "TR273910");
		     doReturn(account).when(accountService).findByAccountNumber("TR273910");
		     @NotNull ResponseEntity<AccountDto> result = accountController.addCredit( "TR273910", new Amount(50.0));
		     verify(accountService, times(2)).findByAccountNumber("TR273910");
		     assertEquals(50.0, account.getBalance(),0.001);
		}
	
		@Test
		public void testDebitthenReturnJson() throws Exception {
		        
		     BankAccount account = new BankAccount("Irmak Tekin", "TR273910");
		     doReturn(account).when(accountService).findByAccountNumber("TR273910");
		     @NotNull ResponseEntity<AccountDto> result = accountController.addCredit( "TR273910", new Amount(20.0));
		     verify(accountService, times(2)).findByAccountNumber("TR273910");
		     assertEquals(20.0, account.getBalance(),0.001);
		}
	
	

}
