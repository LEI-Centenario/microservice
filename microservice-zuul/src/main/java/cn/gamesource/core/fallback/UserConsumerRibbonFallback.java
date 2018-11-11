package cn.gamesource.core.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 用户服务消费者-Ribbon熔断;
 *
 * @author: LEIYU
 */
@Slf4j
@Component
public class UserConsumerRibbonFallback implements FallbackProvider {

    private static final String SERVICE_NAME = "user-service-consumer-ribbon";

    @Override
    public String getRoute() {
        return SERVICE_NAME;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            log.info("网关异常,服务[{}]不可用,原因:[{}]", SERVICE_NAME, reason);
        }
        return CommonCode.fallbackResponse(route);
    }
}
