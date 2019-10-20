package io.github.newhoo.invoker;

import io.github.newhoo.invoker.common.Config;
import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.Instrumentation;

/**
 * BeanInvokerInstrumentation
 *
 * @author huzunrong
 * @since 1.0
 */
@Slf4j
public class BeanInvokerInstrumentation {

    /**
     * Java agent指定的premain方法，会在main方法之前被调用
     */
    public static void premain(String args, Instrumentation inst) {
        // print configuration
        Config.init();
        log.info("Bean invoker port: {}", Config.beanInvokePort);

        // Instrumentation提供的addTransformer方法，在类加载时会回调ClassFileTransformer接口
        inst.addTransformer(new BeanInvokerTransformer());
    }
}