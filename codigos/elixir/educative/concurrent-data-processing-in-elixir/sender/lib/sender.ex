defmodule Sender do
  def send(email) do
    Process.sleep(12000)
    "email_sent #{email}"
  end

  def notificar_todos(emails) do
    Enum.each(emails, fn email ->
      Task.start(fn ->
        send(email)
      end)
    end)
  end

  def asincrono(emails) do
    Enum.each(emails, fn email ->
      Task.async(fn ->
        send(email)
      end)
    end)
  end
end
