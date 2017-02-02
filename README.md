# FolderSizer
List the sizes of folders in a given directory.

It is easy to use if you create an alias.

alias FS='java -jar ~[path]/FS.jar'

##Output Sample
Terminal: FMS /Users/..../FolderSizer
```
║---------------------------------------------------------------------------------------------║
║Name                                                         Size       Type       SubFiles  ║
║---------------------------------------------------------------------------------------------║
║bin                                                          16KB       Folder     1         ║
║src                                                          6KB        Folder     1         ║
║.DS_Store                                                    6KB        File       0         ║
║.git                                                         5KB        Folder     9         ║
║.settings                                                    587B       Folder     1         ║
║.project                                                     370B       File       0         ║
║.classpath                                                   295B       File       0         ║
║README.md                                                    15B        File       0         ║
║.gitignore                                                   6B         File       0         ║
║---------------------------------------------------------------------------------------------║

Terminal: FMS /Users/..../FolderSizer 3

║---------------------------------------------------------------------------------------------║
║Name                                                         Size       Type       SubFiles  ║
║---------------------------------------------------------------------------------------------║
║bin                                                          16KB       Folder     1         ║
║src                                                          6KB        Folder     1         ║
║.DS_Store                                                    6KB        File       0         ║
║---------------------------------------------------------------------------------------------║