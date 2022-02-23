# java-lotto

로또 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### 개요

> 입력한 금액에 따라서 로또 번호를 자동으로 생성하고, 당첨 결과를 알려주는 프로그램


### 목표

##### 공통 목표
- TDD에 맞게 개발 진행해보기
- 원시값 포장해보기
- Enum의 장점을 진심으로 느껴보기
- ‘어떻게’ 보다 ‘무엇을’
##### 야호
- Collection API 활용해보기
##### 포키
- 페어와 이해 수준을 잘 싱크하기
  - stream 전파하기

---

## 기능 요구사항 목록

### 절차에 따른 목록

- [ ]  구입 금액을 입력받는다
    - [X]  [예외] 구입 금액은 숫자여야 한다
    - [X]  [예외] 구입 금액은 0원보다 커야 한다
    - [X]  [예외] 구입 금액은 1000원 단위로 나뉜다

```markdown
구입금액을 입력해 주세요.
14000
```

- [X]  입력받은 금액을 로또의 금액(1000원)으로 나누어서 구매할 로또 수량을 구한다
- [ ]  구매한 로또 수량을 출력한다

```markdown
14개를 구매했습니다.
```

- [X]  수량만큼 로또 번호를 생성한다
    - [X]  로또 한 장에 총 6개 숫자가 포함된다
    - [X]  각 번호는 1 ~ 45 사이의 랜덤값이다
    - [X]  로또 한 장 내에서 숫자는 오름차순으로 정렬된다
- [ ]  생성 로또 번호를 출력한다

```markdown
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]
```

- [ ]  지난 주 당첨 번호를 입력받는다
    - [X]  [예외] 숫자만 입력해야 한다
    - [X]  [예외] 모든 숫자가 1 이상 45 이하여야 한다
    - [X]  [예외] 숫자가 6개여야 한다
    - [X]  [예외] 중복된 숫자가 있을 수 없다

```markdown
지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
```

- [ ]  보너스 번호를 입력받는다
    - [X]  [예외] 숫자만 입력해야 한다
    - [X]  [예외] 1 이상 45 이하여야 한다
    - [X]  [예외] 당첨 번호와 중복되면 안된다

```markdown
보너스 볼을 입력해 주세요.
7
```

- [ ]  당첨 통계를 구해서 출력한다
    - [X]  각 숫자의 일치 여부 구하기
    - [X]  일치하는 숫자의 개수 구하기
    - [X]  일치 개수에 따른 등수 구하기
    - [X]  만약 5개가 일치한다면, 보너스 볼과 일치하는지 확인하기

```markdown
당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
```

- [X]  총 당첨금을 구한다
    - [X]  각 등수별 당첨금을 구한다
- [ ]  수익률을 구해서 출력한다 
    - [X]  수익률 = 총 당첨금 / 구입 금액

```markdown
총 수익률은 0.35입니다.
```

### 도메인 설계

##### InputView

- 구매 금액 입력
- 지난주 당첨 번호, 보너스 번호 입력받기

##### ResultView

- 생성한 로또 출력
- 로또 수량 출력하기
- 당첨 통계 출력
- 수익률 출력하기

##### Money

- 구매 금액을 검사

##### Lotto

- 랜덤값 6개 부여

##### Lottos

- 로또 수량 구하기
- 수량만큼 로또 생성

##### WinningNumber

- 당첨 번호 검사

##### WinningNumbers

- 당첨 번호들과 로또 번호 비교하기
- 당첨 번호들의 개수와 중복 여부 검사

##### Prize

- 맞는 숫자 개수에 따른 당첨금

##### PrizeInformation

- 해당 등수의 당첨금 구하기

##### Controller

- 수익률 구하기
