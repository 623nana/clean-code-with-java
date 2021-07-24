# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.
---
## 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
---
## 구현할 기능 목록
* 참여할 사람 이름을 입력 받는 기능
  * 사람 이름은 쉼표를 기준으로 구분
  * 사람 이름은 최대 5글자로 제한 -> 넘어가는 경우 예외처리
* 실행 결과를 출력하는 기능
    * 입력 받은 사람과 입력 받은 높이에 따라 사다리를 생성
    * 사다리 아래 실행 결과 함께 출력
* 실행 결과(사다리 타기 결과)를 입력 받는 기능
  * 실행 결과는 쉼표를 기준으로 구분
* 실행 결과를 볼 참가자를 입력 받는 기능
  * 한명인 경우 - 한명 결과만 출력
  * all을 입력한 경우 - 모두의 결과 출력
  * 입력한 이름이 참가자에 없는 경우에 대한 예외 처리
---
## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)