# chain-executor  

Пожалуйста, используйте для ознакомления ветку разработки <a href="https://github.com/ezhov-da/chain-executor/tree/dev">[dev]</a> .  
Так же доступна диаграмма отношений **chain-executor.xml** в корне проекта, с которой можно ознакомиться через сайт <a href="https://www.draw.io">draw.io</a> 

**Описание:**  
Проект представляет из себя абстракцию цепи, которая состоит из звеньев и предоставляет возможность создавать цепи на любой "вкус".

Для того, чтоб создать собственную цепь, необходимо:    
* взять источник элементов для цепи - **Source**
* набор элементов - **DataSet**
* сделать из них звенья **Link**
* Соединить каждое звено в цепь - **join**
* Сделать финальную сборку - **build**


Для запуска app-console через IntelliJ Idea без зависимостей от реализаций интерфейсов, необходимо в конфигурации AppConsole указать для VM options:   
-cp app-console\target\app-console.jar;chain-plugin-implementation-datasets\target\chain-plugin-implementation-datasets.jar;chain-plugin-implementation-link\target\chain-plugin-implementation-link.jar