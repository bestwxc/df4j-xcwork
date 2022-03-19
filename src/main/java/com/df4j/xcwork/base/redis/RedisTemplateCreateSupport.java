/*
package com.df4j.xcwork.base.redis;

import com.df4j.xcwork.base.bean.NullObjectProvider;
import com.df4j.xcwork.base.exception.XcworkException;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.data.redis.ClientResourcesBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.JedisClientConfigurationBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

*/
/**
 * 利用反射调用spring-boot-starter-data-redis的初始化redis的配置类来创建相关对象，以复用相关配置
 *//*

public class RedisTemplateCreateSupport {

    */
/**
     * 指定特定的配置前缀，创建RedisProperties
     *
     * @param configPrefix
     * @param environment
     * @return
     *//*

    public static RedisProperties createRedisProperties(String configPrefix, Environment environment) {
        RedisProperties redisProperties = new RedisProperties();
        Binder.get(environment).bind(configPrefix, Bindable.ofInstance(redisProperties));
        return redisProperties;
    }

    */
/**
     * 创建ClientResources
     *
     * @return
     *//*

    public static DefaultClientResources createLettuceClientResources() {
        return createLettuceClientResources(null);
    }

    */
/**
     * 创建ClientResources
     *
     * @param customizers
     * @return
     *//*

    public static DefaultClientResources createLettuceClientResources(ObjectProvider<ClientResourcesBuilderCustomizer> customizers) {
        DefaultClientResources.Builder builder = DefaultClientResources.builder();
        if (!ObjectUtils.isEmpty(customizers)) {
            customizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
        }
        return builder.build();
    }

    */
/**
     * 创建 LettuceConnectionFactory
     *
     * @param properties
     * @param clientResources
     * @return
     *//*

    public static LettuceConnectionFactory createLettuceConnectionFactory(RedisProperties properties,
                                                                          ClientResources clientResources) {
        return createLettuceConnectionFactory(properties, null, null, null, null, clientResources);
    }

    */
/**
     * 创建 LettuceConnectionFactory
     *
     * @param properties
     * @param standaloneConfigurationProvider
     * @param sentinelConfigurationProvider
     * @param clusterConfigurationProvider
     * @param builderCustomizers
     * @param clientResources
     * @return
     *//*

    public static LettuceConnectionFactory createLettuceConnectionFactory(RedisProperties properties,
                                                                          ObjectProvider<RedisStandaloneConfiguration> standaloneConfigurationProvider,
                                                                          ObjectProvider<RedisSentinelConfiguration> sentinelConfigurationProvider,
                                                                          ObjectProvider<RedisClusterConfiguration> clusterConfigurationProvider,
                                                                          ObjectProvider<LettuceClientConfigurationBuilderCustomizer> builderCustomizers,
                                                                          ClientResources clientResources) {
        try {
            if (ObjectUtils.isEmpty(standaloneConfigurationProvider)) {
                standaloneConfigurationProvider = new NullObjectProvider<>();
            }
            if (ObjectUtils.isEmpty(sentinelConfigurationProvider)) {
                sentinelConfigurationProvider = new NullObjectProvider<>();
            }
            if (ObjectUtils.isEmpty(clusterConfigurationProvider)) {
                clusterConfigurationProvider = new NullObjectProvider<>();
            }
            Class redisPropertiesClass = ClassUtils.forName("org.springframework.boot.autoconfigure.data.redis.RedisProperties", null);
            Class lettuceConnectionConfigurationClass = ClassUtils.forName("org.springframework.boot.autoconfigure.data.redis.LettuceConnectionConfiguration", null);
            Constructor constructor = lettuceConnectionConfigurationClass.getDeclaredConstructor(redisPropertiesClass, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class);
            constructor.setAccessible(true);
            Object object = constructor.newInstance(redisPropertiesClass.newInstance(), standaloneConfigurationProvider, sentinelConfigurationProvider, clusterConfigurationProvider);
            Class clientResourcesClass = ClassUtils.forName("io.lettuce.core.resource.ClientResources", null);
            Method method = lettuceConnectionConfigurationClass.getDeclaredMethod("redisConnectionFactory", ObjectProvider.class, clientResourcesClass);
            method.setAccessible(true);
            return (LettuceConnectionFactory) method.invoke(object, builderCustomizers, clientResources);
        } catch (Exception e) {
            throw XcworkException.repack(e);
        }
    }

    */
/**
     * 创建 JedisConnectionFactory
     *
     * @param properties
     * @return
     *//*

    public static JedisConnectionFactory createJedisConnectionFactory(RedisProperties properties) {
        return createJedisConnectionFactory(properties, null, null, null, null);
    }

    */
/**
     * 创建 JedisConnectionFactory
     *
     * @param properties
     * @param standaloneConfigurationProvider
     * @param sentinelConfigurationProvider
     * @param clusterConfigurationProvider
     * @param builderCustomizers
     * @return
     *//*

    public static JedisConnectionFactory createJedisConnectionFactory(RedisProperties properties,
                                                                      ObjectProvider<RedisStandaloneConfiguration> standaloneConfigurationProvider,
                                                                      ObjectProvider<RedisSentinelConfiguration> sentinelConfigurationProvider,
                                                                      ObjectProvider<RedisClusterConfiguration> clusterConfigurationProvider,
                                                                      ObjectProvider<JedisClientConfigurationBuilderCustomizer> builderCustomizers) {
        try {
            if (ObjectUtils.isEmpty(standaloneConfigurationProvider)) {
                standaloneConfigurationProvider = new NullObjectProvider<>();
            }
            if (ObjectUtils.isEmpty(sentinelConfigurationProvider)) {
                sentinelConfigurationProvider = new NullObjectProvider<>();
            }
            if (ObjectUtils.isEmpty(clusterConfigurationProvider)) {
                clusterConfigurationProvider = new NullObjectProvider<>();
            }
            if (ObjectUtils.isEmpty(builderCustomizers)) {
                builderCustomizers = new NullObjectProvider<>();
            }
            Class redisPropertiesClass = ClassUtils.forName("org.springframework.boot.autoconfigure.data.redis.RedisProperties", null);
            Class jedisConnectionConfigurationClass = ClassUtils.forName("org.springframework.boot.autoconfigure.data.redis.JedisConnectionConfiguration", null);
            Constructor constructor = jedisConnectionConfigurationClass.getDeclaredConstructor(redisPropertiesClass, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class);
            constructor.setAccessible(true);
            Object object = constructor.newInstance(redisPropertiesClass.newInstance(), standaloneConfigurationProvider, sentinelConfigurationProvider, clusterConfigurationProvider);
            Method method = jedisConnectionConfigurationClass.getDeclaredMethod("redisConnectionFactory", ObjectProvider.class);
            method.setAccessible(true);
            return (JedisConnectionFactory) method.invoke(object, builderCustomizers);
        } catch (Exception e) {
            throw XcworkException.repack(e);
        }
    }


    */
/**
     * 创建RedisTemplate
     *
     * @param redisConnectionFactory
     * @return
     *//*

    public static RedisTemplate<Object, Object> createRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    */
/**
     * 创建 StringRedisTemplate
     *
     * @param redisConnectionFactory
     * @return
     *//*

    public static StringRedisTemplate createStringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }
}
*/
