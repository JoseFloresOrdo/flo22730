#Allen Estuardo Ramírez De Paz, 22326
#José Javier Flores Ordoñez, 22730
import pandas as pd
import networkx as nx
import matplotlib.pyplot as plt
amarillo="\033[1;33m"
reset= "\033[0m"
rojo="\033[1;31m"
verde="\033[1;32m"


df= pd.read_csv("Ciudades.csv")
G= nx.DiGraph()

for i in range (df.shape[0]):
   
    G.add_edge(df.iloc[i,0],df.iloc[i,1],weight=df.iloc[i,2])

matrizTiempoNormal= nx.floyd_warshall_numpy(G)
continuar= True
matrizActual=matrizTiempoNormal
while (continuar==True):
    opcion=int(input("¿Qué desea hacer?\n(1) Encontrar la distancia más corta entre dos ciudades\n(2) Encontrar el centro del grafo\n(3) Cambiar condiciones climaticas\n(4) Mostrar el grafo\n"))
    if(opcion==1):
        ciudad1=input("Por favor ingrese la ciudad de origen: ")
        ciudad2=input("Ahora ingrese la ciudad destino: ")
        distancia = matrizActual[list(G.nodes).index(ciudad1)][list(G.nodes).index(ciudad2)]
        caminoMasCorto= nx.shortest_path(G,source=ciudad1, target=ciudad2, weight='weight')
        print(amarillo,"La distancia más corta es: ",distancia,reset)
        print(amarillo,"El camino más corto entre ",ciudad1," y ",ciudad2," es: \n",caminoMasCorto,reset)
    elif (opcion==2):
        try:
            centro=nx.center(G)
            print(amarillo,"El centro es: ",centro,reset)
        except:
            print(rojo,"El grafo no está completo",reset)
    elif (opcion==3):
        ciudadCambiar1=input("Ingrese la ciudad 1: ")
        ciudadCambiar2=input("Ingrese la ciudad 2: ")
        clima=int(input("Ingrese la condición climática\n(1) Normal\n(2) Lluvia\n(3) Nieve\n(4) Tormenta\n"))
        fila= df.loc[(df["Ciudad1"]==ciudadCambiar1) & (df["Ciudad2"]==ciudadCambiar2)]
        if fila.empty:
            print(rojo,"No existe esa conexión",reset)
        else:
            peso_nuevo= fila.iloc[0, clima + 1]
            print(peso_nuevo)
            G[ciudadCambiar1][ciudadCambiar2]["weight"]=peso_nuevo
            G[ciudadCambiar2][ciudadCambiar1]["weight"]=peso_nuevo
            matrizActual=nx.floyd_warshall_numpy(G)
            print(verde,"Se ha actualizado",reset)


        
       
        
            
        
        
        
    elif (opcion==4):
        
        pos = nx.spring_layout(G) 
        nx.draw(G, pos, with_labels=True, node_size=700, node_color='skyblue')
        labels = nx.get_edge_attributes(G, 'weight')
        nx.draw_networkx_edge_labels(G, pos, edge_labels=labels)
        plt.show()
