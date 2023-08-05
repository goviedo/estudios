defmodule FuncionesTest do
  use ExUnit.Case
  doctest Funciones

  test "greets the world" do
    assert Funciones.hello() == :world
  end
end
