package ventas;
import javax.swing.JOptionPane;
public class Arbol {
    
   private NodoA raiz;
   
   public Arbol(){
      this.raiz=null;
   } 
   public boolean esVacio(){
      if(raiz==null){
         return true; 
      }else{
         return false;
      }
   }
   public void inserta(){
      Dato d=new Dato();
      d.setNumeroAsiento(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Digite el numero de asiento:")));
      NodoA nuevo=new NodoA();
      nuevo.setElemento(d);
      if(esVacio()){
         raiz=nuevo;
      }else{
         insertarNuevo(raiz,nuevo);
      }
   }
   public void insertarNuevo(NodoA raiz,NodoA nuevo){
      if(nuevo.getElemento().getNumeroAsiento()<=raiz.getElemento().getNumeroAsiento()){
         if(raiz.getEnlaceIzq()==null){
            raiz.setEnlaceIzq(nuevo);
         }else{
            insertarNuevo(raiz.getEnlaceIzq(),nuevo);
         }
      }else{
         if(raiz.getEnlaceDer()==null){
            raiz.setEnlaceDer(nuevo);
         }else{
            insertarNuevo(raiz.getEnlaceDer(),nuevo); 
         }
      }
   }
  public void eliminarTodo(){
     if(!esVacio()){
        raiz=null;
     }else{
        JOptionPane.showMessageDialog(null,"¡No se puede eliminar, árbol vacío!");
     } 
  }
  public void mostrarRaiz(){
     if(!esVacio()){
        mostrarNodo(raiz);
     }else{
        JOptionPane.showMessageDialog(null,"¡No se puede mostrar, árbol vacío!");
     }
  } 
  public void mostrarNodo(NodoA raiz){
     if(raiz!=null){
        mostrarNodo(raiz.getEnlaceIzq());
        System.out.print(raiz.getElemento().getNumeroAsiento());
        mostrarNodo(raiz.getEnlaceDer());
     }
  }
    
}
