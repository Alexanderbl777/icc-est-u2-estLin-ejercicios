package main;

import java.util.*;

public class LogicaClasificacion {

    Stack<Character> pila = new Stack<>();
    Stack<Integer> pilaI = new Stack<>();
    StringBuilder invertir = new StringBuilder();
    LinkedList<Integer> pares = new LinkedList<>();
    LinkedList<Integer> impares = new LinkedList<>();
    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        

        for (char c : texto.toCharArray()) {
            pila.push(c);
        }

        while(!pila.isEmpty()){
            invertir.append(pila.pop());
           
        }

        return invertir.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {

        HashMap<Character,Character> simbolos = new HashMap<>(); 
            simbolos.put(')','(');
            simbolos.put('}','{');
            simbolos.put(']','[');
        for (char c : expresion.toCharArray()) {
            if(c=='('||c=='{'||c=='['){
                pila.push(c);
            }else if(c==')'||c=='}'||c==']'){
                if(pila.isEmpty() || pila.pop()!=simbolos.get(c)){
                    return false;
                }
            }
        }

        return pila.isEmpty();

    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        
        while(!pila.isEmpty()){
            int temp = pila.pop();
            while(!pilaI.isEmpty()&&pilaI.peek()>temp){
                pila.push(pilaI.pop());
            }
            pilaI.push(temp);
        }
        return pilaI;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        for (int i : original) {
            if(i%2==0){
                pares.add(i);
            }else{
                impares.add(i);
            }
        }
        LinkedList<Integer> resultado = new LinkedList<>(pares);
        resultado.addAll(impares);

        return resultado;
    }
}
