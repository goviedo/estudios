import Config

config :kaffe,
  producer: [
    endpoints: [localhost: 9092],
    topics: ["topic_1"]
  ],
  consumer: [
    endpoints: [localhost: 9092],
    topics: ["topic_1"],
    consumer_group: "grupo-consumidor",
    message_handler: Consumer
  ]
