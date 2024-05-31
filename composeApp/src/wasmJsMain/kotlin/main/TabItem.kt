package main

enum class TabRoutEnum {
    SUB_INFO,

    //    BOOKMARK,
    HIGHLIGHT, BASIC_SETTING,
    SEARCH,
    ETC,
    Tab
}

fun TabRoutEnum.toText() = when (this) {
    TabRoutEnum.SUB_INFO -> "특수 표기 정보"
//    TabRoutEnum.BOOKMARK -> "책갈피"
    TabRoutEnum.HIGHLIGHT -> "하이라이트"
    TabRoutEnum.BASIC_SETTING -> "성경 화면 설정"
    TabRoutEnum.ETC -> "기타"
    TabRoutEnum.SEARCH -> "검색"
    TabRoutEnum.Tab -> "탭"
}

