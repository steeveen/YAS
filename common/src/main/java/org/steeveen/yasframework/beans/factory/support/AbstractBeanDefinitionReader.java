package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.core.io.DefaultResourceLoader;
import org.steeveen.yasframework.core.io.ResourceLoader;

/**
 * 对从配置中读取bean注册BeanDefination抽象的进一步实现：
 *  加入了registry和resourceLoader的传输
 *
 * @author steeveen
 * @date 2023/2/19 22:49
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
