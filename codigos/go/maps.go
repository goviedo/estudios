package main

import (
  "fmt"
)

func main() {
  v := make(map[string]int)

  v["a"] = 2
  v["b"] = 7
  v["c"] = 5

  fmt.Println(v)
  delete(v, "c")
  fmt.Println(v)

  for i:=0; i<7;i++ {
    fmt.Println(i)
  }
}

func sum(x int, y int) int {
  return x + y
}
