package multifiesta;

import javax.swing.JOptionPane;

public class Eventos extends Lista {
    private NodoDC inicio;
    private NodoDC fin;
    private NodoLC inicio2;
    private NodoLC fin2;


    public Eventos(){
        this.inicio=null;
        this.fin=null;
        this.inicio2=null;
        this.fin2=null;
    }

    public boolean esVaciaLC(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }

    public boolean esVaciaDC(){
        if(inicio==null){
           return true;
        }else{
            return false;
        }
    }

    public void Menu(){
      int op =(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para agregar\n"+
        "Ingrese 2 para editar catalogo de eventos \n"+   "Ingrese 3 para editar catalogo de asientos \n"+ "Ingresa 4 para invalidar\n"+
        "Ingresa 5 para mostrar eventos\n"+"Ingresa 6 para salir")));
        Menu m=new Menu();
        if(1==op){
            Catalogo_Eventos();
            Catalogo_asientos();
            Menu();
        }else if(2==op){
            editar();
            Menu();
        }else if(3==op){
            editar2();
            Menu();
        }else if(4==op){
           int ot=(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para invalidar Eventos\n"+
           "Ingrese 2 para invalidar Asientos \n"+"Ingresa 3 para salir")));
             if(1==ot){
               inactivarEvento();
             }else if(2==ot){
                inactivarAsiento();
            }else if(3==ot){
                Menu();
            }else{
          JOptionPane.showMessageDialog(null, "Numero incorrecto "+JOptionPane.ERROR_MESSAGE);
            Menu(); 
            }
        }else if(5==op){
           mostrarLC();
           mostrarDC();
           Menu();
        }else if(6==op){
            m.mostrarMenuL();
            Menu();
        }else{
            JOptionPane.showMessageDialog(null, "Numero incorrecto "+JOptionPane.ERROR_MESSAGE);
            Menu();
        }
               
        }
          
    public void Catalogo_Eventos(){
    Eventos_Datos e=new Eventos_Datos();
        e.setNombnreE(JOptionPane.showInputDialog(null,
          "Digite el nombre del evento"));
        e.setFecha(JOptionPane.showInputDialog(null,
          "Digite la fecha"));
        e.setLugar(JOptionPane.showInputDialog(null,
          "Digite el lugar  "));
        e.setDirección(JOptionPane.showInputDialog(null,
         "Digite la dirección con la ciudad"));
        NodoLC nuevo=new NodoLC();
        nuevo.setDato(e);
        if(esVaciaLC()){
           inicio2=nuevo;
           fin2=nuevo;
           fin2.setSiguiente(inicio2);
        }else if(e.getNombnreE().compareTo(inicio2.getDato().getNombnreE())<0){
           nuevo.setSiguiente(inicio2);
           inicio2=nuevo;
           fin2.setSiguiente(inicio2);
        }else if(e.getNombnreE().compareTo(fin.getDato().getNombnreE())>=0){
           fin2.setSiguiente(nuevo);
           fin2=nuevo;
           fin2.setSiguiente(inicio2);
        }else{
           NodoLC aux=inicio2;
           while(aux.getSiguiente().getDato().getNombnreE().compareTo(e.getNombnreE())<0){
               aux=aux.getSiguiente();
           }   
           nuevo.setSiguiente(aux.getSiguiente());
           aux.setSiguiente(nuevo);
        }
    }

    public void Catalogo_asientos(){
        Eventos_Datos e=new Eventos_Datos();
        e.setCodigo_area(Long.parseLong(JOptionPane.showInputDialog(null,
              "Digite el codigo de area")));
        e.setNumeroA(Integer.parseInt(JOptionPane.showInputDialog(null,
              "Digite el nombre del numero de asiento")));
        e.setCosto(Double.parseDouble(JOptionPane.showInputDialog(null,
              "Digite el costo de venta")));
        NodoDC nuevo=new NodoDC();
        nuevo.setDato(e);
        if(esVaciaDC()){
           inicio=nuevo;
           fin=nuevo; 
           fin.setSiguiente(inicio);
           inicio.setAnterior(fin);
        }else if(e.getNumeroA()<inicio.getDato().getNumeroA()){
           nuevo.setSiguiente(inicio);
           inicio=nuevo;
           fin.setSiguiente(inicio);
           inicio.setAnterior(fin);
        }else if(e.getNumeroA()>=fin.getDato().getNumeroA()){
           fin.setSiguiente(nuevo);
           fin=nuevo;  
           fin.setSiguiente(inicio);
           inicio.setAnterior(fin);
        }else{
           NodoDC aux=inicio;
           while(aux.getSiguiente().getDato().getNumeroA()<e.getNumeroA()){
                 aux=aux.getSiguiente();
           }
           nuevo.setSiguiente(aux.getSiguiente());
           nuevo.setAnterior(aux);
           aux.setSiguiente(nuevo);
           nuevo.getSiguiente().setAnterior(nuevo);
        }
    }
    
   
    public void editar(){
        if(!esVaciaLC()){
            NodoLC aux= inicio2;
            String evento = (JOptionPane.
            showInputDialog(null, "Digite el Nombre del evento"));
            if(aux.getDato().getNombnreE().equals(evento)){
                String nuevo = (JOptionPane.
                showInputDialog(null, "Coloque el nuevo dato a editar")); 
                inicio2.getDato().setNombnreE(nuevo);
                   
            }
            aux=aux.getSiguiente();

            while(aux!= inicio2){
                if(aux.getDato().getNombnreE().equals(evento)){
                    String nuevo = (JOptionPane.
                    showInputDialog(null, "Coloque el nuevo dato a editar")); 
                    inicio2.getDato().setNombnreE(nuevo);
                       
                }
                aux=aux.getSiguiente();
            }
            JOptionPane.
            showMessageDialog(null, "Dato editado correctamente",
            "successful",JOptionPane.INFORMATION_MESSAGE); 
            
     }
    
    }

         public void editar2(){
            if(!esVaciaDC()){
                NodoDC aux= inicio;
                int asiento = (Integer.parseInt(JOptionPane.
                showInputDialog(null, "Digite el Numero de asiento")));
                
                if(aux.getDato().getNumeroA()==asiento){
                    int nuevoA = (Integer.parseInt(JOptionPane.
                    showInputDialog(null, "Coloque el nuevo dato a editar"))); 
                    inicio.getDato().setNumeroA(nuevoA);
                   
                }
                aux=aux.getSiguiente();

                while(aux!= inicio){
                    if(aux.getDato().getNumeroA()==asiento){
                        int nuevoA = (Integer.parseInt(JOptionPane.
                        showInputDialog(null, "Coloque el nuevo dato a editar"))); 
                        inicio.getDato().setNumeroA(nuevoA);
                       
                    }
                    }
                    aux=aux.getSiguiente();
                }
                JOptionPane.
                showMessageDialog(null, "Dato editado correctamente",
                "successful",JOptionPane.INFORMATION_MESSAGE); 
         }
    
    public void mostrarLC(){
        if(!esVaciaLC()){
           String s="";
           NodoLC aux=inicio2;
           s=s+aux.getDato().getNombnreE()+"--"+aux.getDato().getFecha()+"--"+
           aux.getDato().getLugar()+"--"+ aux.getDato().getDirección()+"-->";
           aux=aux.getSiguiente();
           while(aux!=inicio2){
            s=s+aux.getDato().getNombnreE()+"--"+aux.getDato().getFecha()+"--"+
            aux.getDato().getLugar()+"--"+ aux.getDato().getDirección()+"-->";
              aux=aux.getSiguiente();
           }
           JOptionPane.showMessageDialog(null,"La lista de Catalago de eventos contiene:\n"+s);
        }else{
           JOptionPane.showMessageDialog(null,"¡No se puede mostrar, lista vacía!",
              "Lista vacía",JOptionPane.ERROR_MESSAGE);
        }
    }
     public void mostrarDC(){
        if(!esVaciaDC()){
           String s="";
           NodoDC aux=inicio;
           s=s+aux.getDato().getNumeroA()+"--"+aux.getDato().getCodigo_area()+"--"+
           aux.getDato().getCosto()+"-->";
           aux=aux.getSiguiente();
           while(aux!=inicio){
            s=s+aux.getDato().getNumeroA()+"--"+aux.getDato().getCodigo_area()+"--"+
           aux.getDato().getCosto()+"-->";
              aux=aux.getSiguiente();
           }
           JOptionPane.showMessageDialog(null,"La lista de Catalogo de asientos contiene:\n"+s);
        }else{
           JOptionPane.showMessageDialog(null,"¡No se puede mostrar, lista vacía!",
              "Lista vacía",JOptionPane.ERROR_MESSAGE);
        }
     }

     public void inactivarEvento(){
        if(!esVaciaLC()){
         String evento=JOptionPane.showInputDialog(null, "Ingrese el evento a invalidar");

         String s = "";
            NodoLC aux = inicio2;
            if (aux.getDato().getNombnreE().equals(evento)) {
                inicio2.getDato().setEstado(inicio2.getDato().getEstado2());
            }
            aux = aux.getSiguiente();

            while (aux != inicio2) {
                if (aux.getDato().getNombnreE().equals(evento)) {
                    inicio2.getDato().setEstado(inicio2.getDato().getEstado2());
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicio2.getDato().getNombnreE()+ " es " + inicio2.getDato().getEstado2());

        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        }
        public void inactivarAsiento(){
            if(!esVaciaDC()){
                int asiento= (Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el asiento a invalidar")));
             String s = "";
                NodoDC aux = inicio;
                if (aux.getDato().getNumeroA() == asiento) {
                    inicio.getDato().setEstado(inicio.getDato().getEstado2());
                }
                aux = aux.getSiguiente();
    
                while (aux != inicio) {
                    if (aux.getDato().getNumeroA() == asiento) {
                        inicio.getDato().setEstado(inicio.getDato().getEstado2());
                    }
                    aux = aux.getSiguiente();
        
                }
                JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicio.getDato().getNumeroA()+ " es " + inicio.getDato().getEstado2());
    
            } else {
                JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            }
     }

