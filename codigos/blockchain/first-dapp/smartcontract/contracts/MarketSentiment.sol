// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.7;

// Import this file to use console.log
import "hardhat/console.sol";

contract MarketSentiment {

    address public owner;
    string[] public thickerArray;

    constructor() {
        owner = msg.sender;
    }

    struct ticker {
        bool exists;
        uint256 up;
        uint256 down;
        mapping(address=>bool) Voters;
    }

    event tickerupdated (
        uint256 up,
        uint256 down,
        address voter,
        string ticker
    );

    mapping(string=>ticker) private Tickers;

    function addTicker(string memory _ticker) public {
        require(msg.sender == owner, "I'm so sorry, only the owner can create ticker");
        ticker storage newTicker = Tickers[_ticker];
        newTicker.exists = true;
        thickerArray.push(_ticker);
    }

    function vote(string memory _ticker, bool _vote) public {
        require(Tickers[_ticker].exists, "Can't vote on this coin");
        require(!Tickers[_ticker].Voters[msg.sender],"Can't vote for this coin again");

        ticker storage tvote = Tickers[_ticker];
        tvote.Voters[msg.sender] = true; // Ya votaste (podra votar por otra moneda?)

        if(_vote) {
            tvote.up++;
        } else {
            tvote.down++;
        }

        // Auditamos
        emit tickerupdated(tvote.up, tvote.down, msg.sender, _ticker);        
    }

    function getVotes(string memory _ticker) public view returns (
        uint256 up,
        uint256 down
    ) {
        require(Tickers[_ticker].exists,"No ticker defined o created");
        ticker storage t = Tickers[_ticker];
        return(t.up,t.down);
    }
}