# Techflash - Hibernate
| Initial State  | Action            | End State |
|----------------|-------------------|-----------|
| None   | get(), load()      |Persistent|
| Transient   | save(), saveOrUpdate()    |Persistent|
| Persistent  | delete()      |Removed|
| Detached   | update(), saveOrUpdate()|Persistent|
|Persistent  | evict()      |Detached|
