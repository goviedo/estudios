defmodule Lista do
	def largo([]), do: 0
	def largo([head|tail]) do
	  1 + largo(tail)
	end

	def c([]), do: []
	def c([head|tail]) do
		[ head*4 | c(tail) ]
	end
end

