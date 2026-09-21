import { useState } from "react";
import "./App.css";

function App() {
  const [sleepTime, setSleepTime] = useState("");
  const [wakeTime, setWakeTime] = useState("");
  const [result, setResult] = useState("");

  const calculateSleep = () => {
    if (!sleepTime || !wakeTime) {
      setResult("취침 시간과 기상 시간을 모두 입력해주세요.");
      return;
    }

    const [sleepHour, sleepMinute] = sleepTime.split(":").map(Number);
    const [wakeHour, wakeMinute] = wakeTime.split(":").map(Number);

    let sleep = sleepHour * 60 + sleepMinute;
    let wake = wakeHour * 60 + wakeMinute;

    // 자정을 넘어가는 경우
    if (wake <= sleep) {
      wake += 24 * 60;
    }

    const totalMinutes = wake - sleep;
    const hours = Math.floor(totalMinutes / 60);
    const minutes = totalMinutes % 60;

    setResult(`총 수면 시간은 ${hours}시간 ${minutes}분입니다.`);
  };

  return (
    <div className="app">
      {/* 배경 장식 */}
      <div className="star star1">✦</div>
      <div className="star star2">✦</div>
      <div className="star star3">✦</div>
      <div className="star star4">•</div>

      <main className="sleep-card">
        {/* 헤더 */}
        <div className="header">
          <div className="moon">🌙</div>

          <h1>수면 시간 계산기</h1>

          <p>더 나은 하루를 위한, 충분한 수면</p>
        </div>

        {/* 시간 입력 영역 */}
        <div className="time-section">
          <div className="time-box">
            <label>
              <span className="label-icon">🛏️</span>
              취침 시간
            </label>

            <input
              type="time"
              value={sleepTime}
              onChange={(e) => setSleepTime(e.target.value)}
            />
          </div>

          <div className="time-box">
            <label>
              <span className="label-icon">☀️</span>
              기상 시간
            </label>

            <input
              type="time"
              value={wakeTime}
              onChange={(e) => setWakeTime(e.target.value)}
            />
          </div>
        </div>

        {/* 계산 버튼 */}
        <button className="calculate-button" onClick={calculateSleep}>
          <span>▣</span>
          수면 시간 계산하기
        </button>

        {/* 결과 */}
        <div className={`result ${result ? "active" : ""}`}>
          <div className="result-icon">🌙</div>

          <div className="result-text">
            {result ? (
              <>
                <strong>수면 시간</strong>
                <p>{result}</p>
              </>
            ) : (
              <>
                <strong>수면 시간을 계산해보세요</strong>
                <p>취침 시간과 기상 시간을 입력해주세요.</p>
              </>
            )}
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;