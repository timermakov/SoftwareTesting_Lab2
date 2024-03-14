import matplotlib.pyplot as plt
import pandas as pd

csv_file_path = 'function_system_output.csv'

data = pd.read_csv(csv_file_path, header=None, names=['x', 'y'])

plt.figure(figsize=(10, 6))
plt.plot(data['x'], data['y'], marker='o', linestyle='-', color='b')
plt.title('Plot of CSV Data')
plt.xlabel('X')
plt.ylabel('Y')
plt.grid(True)
plt.show()
