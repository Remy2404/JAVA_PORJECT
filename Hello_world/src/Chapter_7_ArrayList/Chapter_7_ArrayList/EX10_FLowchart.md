```mermaid
graph LR
    A(Start) --> B{size = list.size()}
    B -->|Yes| C((for (int i = 0; i < size; i++)))
    C -->|Yes| D{min = i}
    D -->|Yes| E((for (int j = i + 1; j < size; j++)))
    E -->|Yes| F{if (list.get(j) < list.get(min))}
    F -->|Yes| G{min = j}
    G --> E
    F -->|No| H{temp = list.get(i)}
    H --> I{list.set(i, list.get(min))}
    I --> J{list.set(min, temp)}
    J --> K{System.out.println(list)}
    K --> L{System.out.println("min: " + min)}
    L --> M{System.out.println("i: " + i)}
    M --> N{System.out.println("temp: " + temp)}
    N --> O{System.out.println("list.get(i): " + list.get(i))}
    O --> P{System.out.println("list.get(min): " + list.get(min))}
    P --> Q{System.out.println("---------------------------------------")}
    Q --> C
    B -->|No| R(End)

    classDef startEnd fill:#f9f,stroke:#333,stroke-width:2px;
    class A R startEnd
    class R R startEnd

```
