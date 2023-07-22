// You can edit this code!
// Click here and start typing.
package main

import "fmt"

func main() {
        var div int = 3 / 2
        nombre := "Gonzalo"
        frase := fmt.Sprintf("Maestro %s usted esta haciendo una division genial, su resultado es: %d", nombre, div)
        fmt.Println(frase)

        fmt.Println("Maestro, necesita algo")
        fmt.Scanln(&nombre)
        fmt.Printf("Usted quiere %s\n", nombre)

        fmt.Println(sumar(10,20))


}

func sumar(a, b int) int {
    return a+b
}
