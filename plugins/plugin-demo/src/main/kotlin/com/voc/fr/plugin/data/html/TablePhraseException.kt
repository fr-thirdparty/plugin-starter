package com.voc.fr.plugin.data.html

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/06 10:18
 */
class TablePhraseException : RuntimeException {

    constructor()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

}