package br.com.propostas.propostas.health;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
@Component
public class CartaoHealth implements HealthIndicator  {
	
	@Value("${health.cartao.url}")
	private String urlSaude;
	
	@Value("${health.cartao.porta}")
	private int porta;

	@Override
	public Health health() {
		Map<String, String> details = new HashMap<>();
		details.put("Api Externa Cartões", "API Geração e Administração de Cartões");
		details.put("URL", urlSaude+"/api/cartoes");
		try (Socket socket = new Socket(new java.net.URL(urlSaude+"/api/cartoes").getHost(), porta)) {
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
        return Health.up().withDetails(details).build();
    }

}
