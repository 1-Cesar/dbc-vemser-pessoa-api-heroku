package br.com.dbc.vemser.pessoaapi;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@Slf4j
@SpringBootApplication
public class PessoaapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaapiApplication.class, args);
		log.info("Seja bem-vindo!");
	}

}
