defmodule PentoWeb.WrongLive do
  use Phoenix.LiveView, layout: { PentoWeb.LayoutView, "live.html" }

  def mount(_params, _session, socket) do
    {:ok, assign(socket, score: 0, message: "Adivina:", hora: time())}
  end

  def render(assigns) do
    ~H"""
    <h1>Puntaje: <%= @score %></h1>
    <h2>
      <%= @message %>
      It's <%= @hora %>
    </h2>
    <h2>
      <%= for n <- 1..10 do %>
        <a href="#" phx-click="guess" phx-value-number= {n} ><%= n %></a>
      <% end %>
    </h2>
    """
  end

  def time() do
    hora = DateTime.utc_now |> to_string
    hora
  end

  def handle_event("guess", %{"number"=>guess, "hora"=>guess}=data, socket) do
    message = "Adivinaste este numero #{guess}, jaaja Wrong!. Adivina de nuevo"
    score = socket.assigns.score - 1
    {
      :noreply,
      assign(
        socket,
        message: message,
        score: score
      )
    }
  end
end
