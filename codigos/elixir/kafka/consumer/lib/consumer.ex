defmodule Consumer do
  def handle_message(%{key: key, value: value} = message) do
    IO.puts("Este lo que hago con el mensaje recibido #{key}: #{value}")
    :ok
  end
end
