
    git submodule add <url> plugins/plugin-XXX
    git submodule add https://github.com/coffee377/fine-plugin-annotation-processor.git plugin-annotation-processor

拉取子模块

    git submodule update --init --recursive

    git clone --recurse-submodules <main_project_url>  # 获取主项目和所有子项目源码
    

### 删除 submodule
1. 删除项目源码子目录
2. 删除 .gitmodules 文件中 submodule 的信息
3. 删除 .git/config 文件中 submodule 的信息
4. 删除 .git/modules/ 目录下 sumodule 的子目录
5. 应用修改