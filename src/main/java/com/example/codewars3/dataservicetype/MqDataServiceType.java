package com.example.codewars3.dataservicetype;

public enum MqDataServiceType {

    RABBIT_MQ {
        @Override
        MqPubSubService getService() {
            ConfigProvider configProvider = ConfigProvider.getInstance();
            RabbitMqServiceImpl.Configuration rabbitMqConfig = configProvider.getRabbitMqConfig();
            return MqttWssPubSubServiceImpl.ofConfig(rabbitMqConfig);
        }

    },

    DEBUG {
        @Override
        MqPubSubService getService() {
            return new LoggingPubSubService();
        }

    };

    public static class ConfigProvider {

        private static ConfigProvider INSTANCE;

        private RabbitMqServiceImpl.Configuration rabbitMqConfig;
        private String config;

        private ConfigProvider() {
            this.config = System.getenv("mqconfig");
        }

        public RabbitMqServiceImpl.Configuration getRabbitMqConfig() {
            if (this.rabbitMqConfig == null)
                this.rabbitMqConfig = RabbitMqServiceImpl.Configuration.configOf("localhost", "443");
            return this.rabbitMqConfig;
        }

        public static ConfigProvider factoryOf() {
            if (INSTANCE != null)
                return INSTANCE;
            return new ConfigProvider();
        }

        public static final ConfigProvider getInstance() {
            return factoryOf();
        }
    }

    abstract MqPubSubService getService();
}
