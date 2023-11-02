defmodule ProducerMemory do
  def memory() do
    push()
  end

  def push() do
    Enum.each(1..5, fn x ->
      Kaffe.Producer.produce_sync(
        "Usuario #{x}",
        to_string(:erlang.memory(:processes_used) / 1024 * 1024)
      )
    end)

    :timer.sleep(5000)
    push()
  end
end
