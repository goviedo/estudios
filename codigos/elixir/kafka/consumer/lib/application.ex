defmodule Consumer.Application do
  use Application

  @impl true
  def start(_type, _args) do
    import Supervisor.Spec

    children = [
      worker(Kaffe.Consumer, [])
    ]

    opts = [strategy: :one_for_one, name: Consumer.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
