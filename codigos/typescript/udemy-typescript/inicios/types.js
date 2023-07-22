var n = 1;
n = 'hola';
var ar = ["Hola", "Como", "estas"];
// Enum
var Estrella;
(function (Estrella) {
    Estrella[Estrella["Galaxia"] = 0] = "Galaxia";
    Estrella[Estrella["Perpra"] = 1] = "Perpra";
    Estrella[Estrella["Vilium"] = 2] = "Vilium";
})(Estrella || (Estrella = {}));
;
var e = Estrella.Vilium;
console.log(e);
