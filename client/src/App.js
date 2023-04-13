import { useEffect, useState } from 'react';
import './App.css';
import jwt_decode from "jwt-decode"

function App() {
  // should use redux instead of hooks for this
  const [ user, setUser ] = useState({});

  console.log(process.env.REACT_APP_TEST);
  console.log(process.env.REACT_APP_G_CLIENT_ID);

  function handleCallbackResponse(response) {
    console.log("encoded jwt id token: " + response.credential)
    var userObject = jwt_decode(response.credential);
    console.log(userObject)
    setUser(userObject)
    document.getElementById("signInDiv").hidden = true;
  }

  function handleSignOut(event) {
    // just setting to empty object
    setUser({});
    document.getElementById("signInDiv").hidden = false;
  }

  useEffect(() => {
    /* global google */
    google.accounts.id.initialize({
      client_id: process.env.REACT_APP_G_CLIENT_ID,
      callback: handleCallbackResponse
    });

    google.accounts.id.renderButton(
      document.getElementById("signInDiv"),
      { theme: "outline", size:"large"}
    );

      google.accounts.id.prompt();
  }, [])

  // if no user: show sign in 
  
  // if has user: show sign out

  return (
    <div className="App">
      <div id="signInDiv"></div>

      { Object.keys(user).length !== 0 &&
        <button onClick={ (e) => handleSignOut(e)}> Sign out</button>
      }

      { user && 
        <div>
          <img src={user.picture}></img>
          <h3>{user.name}</h3>
        </div>
      }
    </div>
  );
}

export default App;
