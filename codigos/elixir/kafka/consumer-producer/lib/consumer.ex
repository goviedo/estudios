defmodule Consumer do
  def handle_message(%{key: key, value: value} = message) do
    IO.inspect(message)
    IO.puts("Esto es #{key}: #{value}")
    :ok
  end
end
