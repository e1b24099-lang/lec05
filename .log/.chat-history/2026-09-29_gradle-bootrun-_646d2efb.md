# gradle bootrun エラー

| | |
|---|---|
| **Created** | 2026-09-29 05:04:13 |
| **Last Message** | 2026-09-29 05:04:13 |
| **Model** | Auto |
| **Mode** | agent |
| **User** | Unknown |
| **Session ID** | `646d2efb-6424-4722-8e78-82cbf1e8a2c8` |

---

## User

*2026-09-29 05:13:58*

gradle bootrunができない

## Assistant (copilot/auto)

> **🔧 ✓ To Do 項目が 3 件作成されました**

> **🔧 ✓ Checking [](file:///c%3A/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot_samples)**

> **🔧 ✓ Reading [](file:///c%3A/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot_samples/src/main/resources/application.properties)**

> **🔧 ✓ Reading [](file:///c%3A/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot_samples/src/main/java/oit/is/inudaisuki/springboot_samples/SpringbootSamplesApplication.java)**

> **🔧 ✓ Reading [](file:///c%3A/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot_samples/build.gradle)**

> **🔧 ✓ Tool call**

> **🔧 ✓ 開始中: *原因に合わせて修正する* (2/3)**

> **🔧 ✓ ` powershell -NoProfile -Command "$listeners = Get-NetTCPConnection -LocalPort...` を実行しています**

> **🔧 ✓ ` powershell -NoProfile -Command "$listeners = Get-NetTCPConnection -LocalPort...` を実行しています**

> **🔧 ✓ ` netstat -ano | grep ':8000'` を実行しています**

> **🔧 ✓ 完了済み: *原因に合わせて修正する* (2/3)**

`gradle bootrun`自体は動いています。失敗原因は **8000番ポートがすでに使用中** です。ログにも `Port 8000 was already in use.` と出ています。

別のターミナルで起動中のSpring Bootアプリがあれば、そこで `Ctrl+C` を押して停止してから再実行してください。停止できない場合は、`` のポートを `8001` などに変更して起動できます。

MyBatisやThymeleafの警告は今回の起動失敗の原因ではありません。

---

## User

*2026-09-29 05:35:34*

解決して

## Assistant (copilot/auto)

I will fix the startup issue by changing the app to use a free port and then verify it boots successfully.

```

> *[Code edit applied]*

```
The port conflict is fixed in the app configuration. I’m starting the app on a free port now to make sure it actually launches.

> **🔧 ✓ ` cd "C:/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot\_samples" && gradl...` を実行しています**

> **🔧 ✓ ` cd "C:/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot\_samples" && gradl...` を実行しています**

## ✅ 解決しました

原因は、`application.properties` のポートが 8000 で、すでに他のプロセスが使っていたことでした。  
そのため、アプリを 8081 に変更して起動させています。

### 変更内容
- `application.properties`
  - server.port=8000
  - → server.port=8081

### 確認結果
起動コマンドを実行し、以下のログを確認しました。

- “Tomcat initialized with port 8081 (http)”
- “Tomcat started on port 8081 (http) with context path '/'”
- “Started SpringbootSamplesApplication ...”

つまり、Spring Boot は正常に起動しています。

### ブラウザ確認
次のURLで表示できます。

- http://localhost:8081/

必要なら次に、index.html の内容をもっと見やすくしたり、DB接続やMyBatis の警告も整理できます。

---

## User

*2026-09-29 06:44:34*

解決して

## Assistant (copilot/auto)

I’m checking the current app state and the exact failure again, then I’ll fix the remaining issue and verify it starts cleanly.

> **🔧 ✓ ` cd "C:/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot\_samples" && ./gra...` を実行しています**

> **🔧 ✓ ` cd "C:/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot\_samples" && ./gra...` を実行しています**

> **🔧 ✓ Tool call**

> **🔧 ✓ Tool call**

---

## User

*2026-09-29 06:45:26*

[Terminal a3d5f4f5-27e1-4d3f-8424-eb715fb90fdc notification: command completed with exit code 1. The terminal has been cleaned up.]
Terminal output:

mikiy@sssdd99 MINGW64 ~/kadai/isdev26
$  cd "C:/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot_samples" && ./gradlew bootRun --stacktrace
Picked up _JAVA_OPTIONS: -Dfile.encoding=SHIFT-JIS

> Task :bootRun
Picked up _JAVA_OPTIONS: -Dfile.encoding=SHIFT-JIS

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.7)

2026-09-29T15:45:23.703+09:00  INFO 33512 --- [           main] o.i.i.s.SpringbootSamplesApplication     : Starting SpringbootSamplesApplication using Java 25.0.4 with PID 33512 (C:\Users\mikiy\oithomes\isdev\kadai\isdev26\springboot_samples\build\classes\java\main started by mikiy in C:\Users\mikiy\oithomes\isdev\kadai\isdev26\springboot_samples)
2026-09-29T15:45:23.706+09:00  INFO 33512 --- [           main] o.i.i.s.SpringbootSamplesApplication     : No active profile set, falling back to 1 default profile: "default"
2026-09-29T15:45:24.410+09:00  WARN 33512 --- [           main] o.m.s.mapper.ClassPathMapperScanner      : No MyBatis mapper was found in '[oit.is.inudaisuki.springboot_samples]' package. Please check your configuration.
2026-09-29T15:45:24.816+09:00  INFO 33512 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat initialized with port 8081 (http)
2026-09-29T15:45:24.833+09:00  INFO 33512 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-09-29T15:45:24.834+09:00  INFO 33512 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/11.0.22]
2026-09-29T15:45:24.897+09:00  INFO 33512 --- [           main] b.w.c.s.WebApplicationContextInitializer : Root WebApplicationContext: initialization completed in 1135 ms
2026-09-29T15:45:24.999+09:00  INFO 33512 --- [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-09-29T15:45:25.213+09:00  WARN 33512 --- [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (please add some templates, check your Thymeleaf configuration, or set spring.thymeleaf.check-template-location=false)
2026-09-29T15:45:25.371+09:00  WARN 33512 --- [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.context.ApplicationContextException: Failed to start bean 'webServerStartStop'
2026-09-29T15:45:25.385+09:00  INFO 33512 --- [           main] .s.b.a.l.ConditionEvaluationReportLogger : 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2026-09-29T15:45:25.402+09:00 ERROR 33512 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Web server failed to start. Port 8081 was already in use.

Action:

Identify and stop the process that's listening on port 8081 or configure this application to listen on another port.


> Task :bootRun FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':bootRun' (registered by plugin 'org.springframework.boot').
> Process 'command 'C:\oit\isdev26-byod\amazonjdk25.0.4_7\bin\java.exe'' finished with non-zero exit value 1

* Try:
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights from a Build Scan (powered by Develocity).
> Get more help at https://help.gradle.org.

* Exception is:
org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':bootRun' (registered by plugin 'org.springframework.boot').
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.lambda$executeIfValid$1(ExecuteActionsTaskExecuter.java:135)
        at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:288)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:133)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:121)
        at org.gradle.api.internal.tasks.execution.ProblemsTaskPathTrackingTaskExecuter.execute(ProblemsTaskPathTrackingTaskExecuter.java:41)
        at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
        at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
        at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
        at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:74)
        at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
        at org.gradle.execution.plan.DefaultNodeExecutor.executeLocalTaskNode(DefaultNodeExecutor.java:55)
        at org.gradle.execution.plan.DefaultNodeExecutor.execute(DefaultNodeExecutor.java:34)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:355)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:343)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.lambda$execute$0(DefaultTaskExecutionGraph.java:339)
        at org.gradle.internal.operations.CurrentBuildOperationRef.with(CurrentBuildOperationRef.java:84)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:339)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:328)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:459)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:376)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)
Caused by: org.gradle.process.ProcessExecutionException: Process 'command 'C:\oit\isdev26-byod\amazonjdk25.0.4_7\bin\java.exe'' finished with non-zero exit value 1
        at org.gradle.process.internal.DefaultExecHandle$ExecResultImpl.assertNormalExitValue(DefaultExecHandle.java:459)
        at org.gradle.process.internal.DefaultJavaExecAction.execute(DefaultJavaExecAction.java:58)
        at org.gradle.api.tasks.JavaExec.exec(JavaExec.java:167)
        at org.springframework.boot.gradle.tasks.run.BootRun.exec(BootRun.java:75)
        at org.gradle.internal.reflect.JavaMethod.invoke(JavaMethod.java:125)
        at org.gradle.api.internal.project.taskfactory.StandardTaskAction.doExecute(StandardTaskAction.java:58)
        at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:51)
        at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:29)
        at org.gradle.api.internal.tasks.execution.TaskExecution$3.run(TaskExecution.java:259)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:30)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:27)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.run(DefaultBuildOperationRunner.java:48)
        at org.gradle.api.internal.tasks.execution.TaskExecution.executeAction(TaskExecution.java:244)
        at org.gradle.api.internal.tasks.execution.TaskExecution.executeActions(TaskExecution.java:227)
        at org.gradle.api.internal.tasks.execution.TaskExecution.executeWithPreviousOutputFiles(TaskExecution.java:210)
        at org.gradle.api.internal.tasks.execution.TaskExecution.execute(TaskExecution.java:176)
        at org.gradle.internal.execution.steps.ExecuteStep.executeInternal(ExecuteStep.java:167)
        at org.gradle.internal.execution.steps.ExecuteStep.access$000(ExecuteStep.java:47)
        at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:137)
        at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:134)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:210)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:205)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:67)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:60)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:167)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:60)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:54)
        at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:134)
        at org.gradle.internal.execution.steps.ExecuteStep$Mutable.execute(ExecuteStep.java:80)
        at org.gradle.internal.execution.steps.CancelExecutionStep.execute(CancelExecutionStep.java:42)
        at org.gradle.internal.execution.steps.TimeoutStep.executeWithoutTimeout(TimeoutStep.java:75)
        at org.gradle.internal.execution.steps.TimeoutStep.execute(TimeoutStep.java:55)
        at org.gradle.internal.execution.steps.PreCreateOutputParentsStep.execute(PreCreateOutputParentsStep.java:51)
        at org.gradle.internal.execution.steps.PreCreateOutputParentsStep.execute(PreCreateOutputParentsStep.java:29)
        at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.executeMutable(RemovePreviousOutputsStep.java:67)
        at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.executeMutable(RemovePreviousOutputsStep.java:39)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:42)
        at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:24)
        at org.gradle.internal.execution.steps.CaptureOutputsAfterExecutionStep.execute(CaptureOutputsAfterExecutionStep.java:69)
        at org.gradle.internal.execution.steps.CaptureOutputsAfterExecutionStep.execute(CaptureOutputsAfterExecutionStep.java:46)
        at org.gradle.internal.execution.steps.ResolveInputChangesStep.executeMutable(ResolveInputChangesStep.java:39)
        at org.gradle.internal.execution.steps.ResolveInputChangesStep.executeMutable(ResolveInputChangesStep.java:28)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.BuildCacheStep.executeWithoutCache(BuildCacheStep.java:189)
        at org.gradle.internal.execution.steps.BuildCacheStep.lambda$execute$1(BuildCacheStep.java:76)
        at org.gradle.internal.Either$Right.fold(Either.java:176)
        at org.gradle.internal.execution.caching.CachingState.fold(CachingState.java:62)
        at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:74)
        at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:49)
        at org.gradle.internal.execution.steps.StoreExecutionStateStep.executeMutable(StoreExecutionStateStep.java:46)
        at org.gradle.internal.execution.steps.StoreExecutionStateStep.executeMutable(StoreExecutionStateStep.java:35)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.executeBecause(SkipUpToDateStep.java:75)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.lambda$execute$2(SkipUpToDateStep.java:53)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:53)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:35)
        at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:37)
        at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:27)
        at org.gradle.internal.execution.steps.ResolveMutableCachingStateStep.executeDelegate(ResolveMutableCachingStateStep.java:70)
        at org.gradle.internal.execution.steps.ResolveMutableCachingStateStep.executeDelegate(ResolveMutableCachingStateStep.java:32)
        at org.gradle.internal.execution.steps.AbstractResolveCachingStateStep.execute(AbstractResolveCachingStateStep.java:69)
        at org.gradle.internal.execution.steps.AbstractResolveCachingStateStep.execute(AbstractResolveCachingStateStep.java:37)
        at org.gradle.internal.execution.steps.ResolveChangesStep.executeMutable(ResolveChangesStep.java:63)
        at org.gradle.internal.execution.steps.ResolveChangesStep.executeMutable(ResolveChangesStep.java:34)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.ValidateStep$Mutable.executeDelegate(ValidateStep.java:79)
        at org.gradle.internal.execution.steps.ValidateStep$Mutable.executeDelegate(ValidateStep.java:65)
        at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:99)
        at org.gradle.internal.execution.steps.ValidateStep$Mutable.execute(ValidateStep.java:65)
        at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.executeMutable(CaptureMutableStateBeforeExecutionStep.java:86)
        at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.execute(CaptureMutableStateBeforeExecutionStep.java:65)
        at org.gradle.internal.execution.steps.CaptureMutableStateBeforeExecutionStep.execute(CaptureMutableStateBeforeExecutionStep.java:45)
        at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeWithNonEmptySources(SkipEmptyMutableWorkStep.java:210)
        at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeMutable(SkipEmptyMutableWorkStep.java:85)
        at org.gradle.internal.execution.steps.SkipEmptyMutableWorkStep.executeMutable(SkipEmptyMutableWorkStep.java:53)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsStartedStep.execute(MarkSnapshottingInputsStartedStep.java:38)
        at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.executeMutable(LoadPreviousExecutionStateStep.java:36)
        at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.executeMutable(LoadPreviousExecutionStateStep.java:23)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.HandleStaleOutputsStep.executeMutable(HandleStaleOutputsStep.java:77)
        at org.gradle.internal.execution.steps.HandleStaleOutputsStep.executeMutable(HandleStaleOutputsStep.java:43)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.lambda$executeMutable$0(AssignMutableWorkspaceStep.java:34)
        at org.gradle.api.internal.tasks.execution.TaskExecution$4.withWorkspace(TaskExecution.java:305)
        at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.executeMutable(AssignMutableWorkspaceStep.java:30)
        at org.gradle.internal.execution.steps.AssignMutableWorkspaceStep.executeMutable(AssignMutableWorkspaceStep.java:21)
        at org.gradle.internal.execution.steps.MutableStep.execute(MutableStep.java:26)
        at org.gradle.internal.execution.steps.ChoosePipelineStep.execute(ChoosePipelineStep.java:40)
        at org.gradle.internal.execution.steps.ChoosePipelineStep.execute(ChoosePipelineStep.java:23)
        at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.lambda$execute$2(ExecuteWorkBuildOperationFiringStep.java:67)
        at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.execute(ExecuteWorkBuildOperationFiringStep.java:67)
        at org.gradle.internal.execution.steps.ExecuteWorkBuildOperationFiringStep.execute(ExecuteWorkBuildOperationFiringStep.java:39)
        at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:46)
        at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:34)
        at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:56)
        at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:38)
        at org.gradle.internal.execution.impl.DefaultExecutionEngine$1.execute(DefaultExecutionEngine.java:68)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:132)
        ... 30 more


BUILD FAILED in 36s
4 actionable tasks: 4 executed




## Assistant (copilot/auto)

I’ve narrowed it down to a port conflict: the old Spring app is still holding the port, so I’m clearing the stale process and switching to a clean port to prevent this from recurring.

> **🔧 ✓ ` cmd.exe /c "wmic process where name='java.exe' get ProcessId,CommandLine"` を実行しています**

> **🔧 ✓ ` powershell.exe -NoProfile -Command "Get-CimInstance Win32\_Process -Filter "n...` を実行しています**

> **🔧 ✓ ` tasklist /FI "IMAGENAME eq java.exe"` を実行しています**

> **🔧 ✓ ` which lsof || which ss || which netstat || which powershell || which pwsh ||...` を実行しています**

> **🔧 ✓ ` jcmd -l` を実行しています**

> **🔧 ✓ ` jcmd 28108 help | head -80` を実行しています**

```

> *[Code edit applied]*

```

> **🔧 ✓ ` kill -9 28108 28188 || true; jcmd -l` を実行しています**

> **🔧 ✓ ` ls -l '/c/Windows/System32/taskkill.exe' '/c/Windows/System32/WindowsPowerSh...` を実行しています**

> **🔧 ✓ ` '/c/Windows/System32/WindowsPowerShell/v1.0/powershell.exe' -NoProfile -Comm...` を実行しています**

> **🔧 ✓ ` '/c/Windows/System32/WindowsPowerShell/v1.0/powershell.exe' -NoProfile -Comm...` を実行しています**

---

## User

*2026-09-29 06:47:45*

[Terminal 3dfafd89-9158-4104-becc-d1418eca5334 notification: command completed with exit code 127. The terminal has been cleaned up.]
Terminal output:

mikiy@sssdd99 MINGW64 ~/kadai/isdev26
$  cd "C:/Users/mikiy/oithomes/isdev/kadai/isdev26/springboot_samples" && gradle bootrun
Picked up _JAVA_OPTIONS: -Dfile.encoding=SHIFT-JIS

> Task :bootRun
Picked up _JAVA_OPTIONS: -Dfile.encoding=SHIFT-JIS

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.7)

2026-09-29T14:35:58.794+09:00  INFO 28108 --- [           main] o.i.i.s.SpringbootSamplesApplication     : Starting SpringbootSamplesApplication using Java 25.0.4 with PID 28108 (C:\Users\mikiy\oithomes\isdev\kadai\isdev26\springboot_samples\build\classes\java\main started by mikiy in C:\Users\mikiy\oithomes\isdev\kadai\isdev26\springboot_samples)
2026-09-29T14:35:58.797+09:00  INFO 28108 --- [           main] o.i.i.s.SpringbootSamplesApplication     : No active profile set, falling back to 1 default profile: "default"
2026-09-29T14:35:59.564+09:00  WARN 28108 --- [           main] o.m.s.mapper.ClassPathMapperScanner      : No MyBatis mapper was found in '[oit.is.inudaisuki.springboot_samples]' package. Please check your configuration.
2026-09-29T14:36:00.034+09:00  INFO 28108 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat initialized with port 8081 (http)
2026-09-29T14:36:00.059+09:00  INFO 28108 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-09-29T14:36:00.060+09:00  INFO 28108 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/11.0.22]
2026-09-29T14:36:00.124+09:00  INFO 28108 --- [           main] b.w.c.s.WebApplicationContextInitializer : Root WebApplicationContext: initialization completed in 1255 ms
2026-09-29T14:36:00.258+09:00  INFO 28108 --- [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-09-29T14:36:00.483+09:00  WARN 28108 --- [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (please add some templates, check your Thymeleaf configuration, or set spring.thymeleaf.check-template-location=false)
2026-09-29T14:36:00.826+09:00  INFO 28108 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat started on port 8081 (http) with context path '/'
2026-09-29T14:36:00.832+09:00  INFO 28108 --- [           main] o.i.i.s.SpringbootSamplesApplication     : Started SpringbootSamplesApplication in 2.589 seconds (process running for 2.957)
2026-09-29T14:36:23.760+09:00  INFO 28108 --- [nio-8081-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-09-29T14:36:23.761+09:00  INFO 28108 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-09-29T14:36:23.763+09:00  INFO 28108 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
[############...] 80% EXECUTING [1h 10m 51s]
> :bootRun


## Assistant (copilot/auto)

> **🔧 ✓ ` '/c/Windows/System32/taskkill.exe' /PID 28108 /F; '/c/Windows/System32/taskk...` を実行しています**

> **🔧 ✓ ` ls -l 'C:/Windows/System32/cmd.exe' 'C:/Windows/System32/taskkill.exe'` を実行しています**

> **🔧 ✓ Tool call**

> **🔧 ✓ ` C:/Windows/System32/cmd.exe /c "taskkill /PID 28108 /F && taskkill /PID 2818...` を実行しています**

> **🔧 ✓ ` C:/Windows/System32/cmd.exe /c "taskkill /PID 28108 /F && taskkill /PID 2818...` を実行しています**

> **🔧 ✓ ` C:/Windows/System32/cmd.exe /c "taskkill /PID 28108 /F && taskkill /PID 2818...` を実行しています**

> **🔧 ✓ ` jcmd -l | grep -E 'SpringbootSamplesApplication|bootrun' || echo 'No stale S...` を実行しています**

> **🔧 ✓ ` jcmd -l | grep -E 'SpringbootSamplesApplication|bootrun' || echo 'No stale S...` を実行しています**

---

