defmodule Lista do

	def reduce([], value, _) do 
	  value
	end

	def reduce([head | tail], value, funcion) do
	  reduce(tail, funcion.(head, value), funcion)
	end
end

