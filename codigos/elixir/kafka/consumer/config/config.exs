import Config

config :kaffe,
  consumer: [
    endpoints: [localhost: 9092],
    topics: ["topic_1"],
    consumer_group: "consumer-group-1",
    message_handler: Consumer
  ]
