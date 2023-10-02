package org.khasanof.news;

import org.khasanof.config.javaBasedConfig.CustomSessionFactoryBuilder;

/**
 * @author Nurislom
 * @see org.khasanof.news
 * @since 10/1/2023 6:56 PM
 */
public abstract class AbstractSessionFactory {

    protected static final CustomSessionFactoryBuilder SESSION_FACTORY_BUILDER = new CustomSessionFactoryBuilder();

}
