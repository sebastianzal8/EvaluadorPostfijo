/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();

        for (String elem : expresion) {
            if (elem.equals("+")) {
                int numero1 = pila.pop(); // primer numero
                int numero2 = pila.pop(); //Siguiente numero
                int suma = numero1 + numero2;
                pila.push(suma);//suma de los dos
            }else if (elem.equals("-")) {
                int numero1 = pila.pop(); // primer numero
                int numero2 = pila.pop(); //Siguiente numero
                int resta = numero1 - numero2;
                pila.push(resta);//resta de los dos
            } else if (elem.equals("*")) {
                int numero1 = pila.pop(); // primer numero
                int numero2 = pila.pop(); //Siguiente numero
                int multi = numero1 * numero2;
                pila.push(multi);//multiplica de los dos
            } else if (elem.equals("/")) {
                int numero1 = pila.pop(); // primer numero
                int numero2 = pila.pop(); //Siguiente numero
                int divi = numero1 / numero2;
                pila.push(divi);//divide los dos
            } else if (elem.equals("%")) {
                int numero1 = pila.pop(); // primer numero
                int numero2 = pila.pop(); //Siguiente numero
                int modu = numero1 % numero2;
                pila.push(modu);//modulo de los dos
            }
            else {
                int num = Integer.parseInt(elem);
                pila.push(num);
            }
        }
        // TODO: Realiza la evaluación de la expresión en formato postfijo

        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
