package org.delcom.usernamepbo2026springbootcashflow;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Meta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Meta(name = "description", content = "Cashflow: aplikasi pencatatan pemasukan, pengeluaran, dan saldo keuangan sederhana.")
@SpringBootApplication
public class App implements AppShellConfigurator {

    public static void main(String[] args) throws Exception {
        DotEnv.load();
        SpringApplication.run(App.class, args);
    }
}