# Script for populating the database. You can run it as:
#
#     mix run priv/repo/seeds.exs
#
# Inside the script, you can read and write to any of your
# repositories directly:
#
#     Pento.Repo.insert!(%Pento.SomeSchema{})
#
# We recommend using the bang functions (`insert!`, `update!`
# and so on) as they will fail if something goes wrong.

alias Pento.Catalog

products = [
	%{
		name: "Ajedrez",
		description: "Un juego culiao dificil",
		sku: 5_678_990,
		unit_price: 10.00
	},
	%{
		name: "Dama",
		description: "Simple pero mas aburrido que la xuxa",
		sku: 10500,
		unit_price: 3.00
	},
	%{
		name: "Bopit!",
		description: "Entretenida la wea, pero 0 intelecto",
		sku: 4_550_500,
		unit_price: 7.00
	}
]

Enum.each(products, fn product ->
	Catalog.create_product(product)
end)	
