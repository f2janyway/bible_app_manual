package main

enum class TabRoutEnum{
    SUB_INFO,
//    BOOKMARK,
    HIGHLIGHT,BASIC_SETTING
}
fun TabRoutEnum.toText() = when(this){
    TabRoutEnum.SUB_INFO -> "인명,지명 등"
//    TabRoutEnum.BOOKMARK -> "책갈피"
    TabRoutEnum.HIGHLIGHT -> "하이라이트"
    TabRoutEnum.BASIC_SETTING -> "성경 화면 설정"
}

