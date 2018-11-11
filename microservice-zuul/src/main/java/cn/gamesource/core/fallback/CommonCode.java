package cn.gamesource.core.fallback;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 网关服务熔断公共方法
 *
 * @author: LEIYU
 */
public class CommonCode {
    /**
     * @description: 网关服务熔断公共返回数据;
     * @author: LEIYU
     */
    public static ClientHttpResponse fallbackResponse(String route) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return 200;
            }

            @Override
            public String getStatusText() {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {
                String serviceName = "[" + route + "]服务暂时不可用";
                return new ByteArrayInputStream(serviceName.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
