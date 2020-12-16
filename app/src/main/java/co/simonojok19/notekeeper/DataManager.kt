package co.simonojok19.notekeeper

class DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>();

    init {
        initializeCourses()
    }

    private fun initializeCourses() {
        var course = CourseInfo(courseId = "android_intents", title = "Android Programming with intents")
        courses[course.courseId] = course

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses[course.courseId] = course

        course = CourseInfo(courseId = "java_core", title = "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course
    }
}