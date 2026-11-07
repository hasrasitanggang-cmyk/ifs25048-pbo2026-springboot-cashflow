package org.delcom.usernamepbo2026springbootcashflow;

import org.delcom.usernamepbo2026springbootcashflow.adapter.presenter.FinancePresenter;
import org.delcom.usernamepbo2026springbootcashflow.domain.repository.ITransactionRepository;
import org.delcom.usernamepbo2026springbootcashflow.usecase.FinanceUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AppTest {

    @Autowired
    private ITransactionRepository repository;

    @Autowired
    private FinanceUseCase useCase;

    @Autowired
    private FinancePresenter presenter;

    @Test
    void contextLoadsAndBeansAreWired() {
        assertNotNull(repository);
        assertNotNull(useCase);
        assertNotNull(presenter);
    }

    @Test
    void balanceIsIncomeMinusExpense() throws Exception {
        double before = useCase.getBalance();
        useCase.addIncome("Gaji", 1_000_000);
        useCase.addExpense("Makan", 25_000);
        assertEquals(before + 975_000, useCase.getBalance(), 0.001);
        assertEquals("Rp 1,000,000.00", presenter.formatMoney(1_000_000));
    }
}
