defmodule Dictionary do
  def readFile, do: File.read!("assets/words.txt")
  def createList, do: String.split(readFile(), ~r/\n/, trim: true)
  def random, do: Enum.random(createList())
end
