import simpy
import random
import statistics

random.seed(42)

class RAM:
    def __init__(self, env, capacity, speed):
        self.env = env
        self.memory = simpy.Container(env, capacity, init=capacity)
        self.speed = speed  # Velocidad de la RAM en unidades de tiempo por MB

    def allocate(self, size):
        return self.memory.get(size)

    def deallocate(self, size):
        return self.memory.put(size)

def proceso(env, nombre, ram, size, tiempos_procesos):
    inicio = env.now
    print(f"{nombre} solicita {size} MB de RAM en el tiempo {env.now}")
    yield ram.allocate(size)
    print(f"{nombre} asigna {size} MB de RAM en el tiempo {env.now}")
    yield env.timeout(size * ram.speed)  # Simulación de uso de la memoria (proporcional a la velocidad)
    print(f"{nombre} libera {size} MB de RAM en el tiempo {env.now}")
    yield ram.deallocate(size)
    fin = env.now
    tiempo_total = fin - inicio
    tiempos_procesos.append(tiempo_total)

def generar_procesos(env, rams, num_procesos, tiempos_procesos):
    for i in range(num_procesos):
        nombre = f"Proceso_{i+1}"
        size = random.randint(1, 50)
        ram = random.choice(rams)  # Seleccionar aleatoriamente una de las dos RAMs
        env.process(proceso(env, nombre, ram, size, tiempos_procesos))
        factor = 1 / ((i + 1) / num_procesos) # Factor que aumenta hacia el final de la simulación
        tiempo_llegada = random.expovariate(1.0 / 1)
        yield env.timeout(tiempo_llegada)

env = simpy.Environment()
velocidad_ram = 1 # Velocidad de la RAM en unidades de tiempo por MB
capacidad_ram = 100  # Capacidad total de la memoria RAM en MB

ram1 = RAM(env, capacity=capacidad_ram, speed=velocidad_ram)
ram2 = RAM(env, capacity=capacidad_ram, speed=velocidad_ram)

rams = [ram1, ram2]

num_procesos = 200
tiempos_procesos = []

env.process(generar_procesos(env, rams, num_procesos, tiempos_procesos))

env.run()  # Ejecutar la simulación durante 50 unidades de tiempo

promedio_tiempo = sum(tiempos_procesos) / len(tiempos_procesos)
print(f"El tiempo promedio de los procesos fue de {promedio_tiempo:.2f} unidades de tiempo.")
desviacion_estandar = statistics.stdev(tiempos_procesos)
print(f"La desviación estándar de los tiempos de ejecución de los procesos fue de {desviacion_estandar:.2f} unidades de tiempo.")
