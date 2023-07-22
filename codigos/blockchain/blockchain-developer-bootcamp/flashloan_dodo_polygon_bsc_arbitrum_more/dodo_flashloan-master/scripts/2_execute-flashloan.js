const hre = require("hardhat");

async function main() {
  console.log(`Preparing Transaction...\n`);

  // Fetch the deployed contract
  const address = "0x6f8Cf643fb1A387A73e1076e1bFDf6496934A701";
  const dodoFlashloan = await hre.ethers.getContractAt("Flashloan", address);
  console.log(`Contract fetched: ${dodoFlashloan.address}`);

  // Fetch account
  const [account] = await ethers.getSigners();
  console.log(`Account fetched: ${account.address}\n`);

  // Perform flashloan
  const pool = "0x5333Eb1E32522F1893B7C9feA3c263807A02d561";
  const WETH = "0x7ceB23fD6bC0adD59E62ac25578270cFf1b9f619";
  const amount = ethers.utils.parseUnits("1", "ether");

  console.log(`Executing Flashloan...\n`);

  const transaction = await dodoFlashloan
    .connect(account)
    .dodoFlashLoan(pool, amount, WETH);
  const result = await transaction.wait();

  console.log(`Transaction Successful!\n`);
  console.log(`-- View Transaction --`);
  console.log(`https://polygonscan.com/tx/${result.transactionHash}`);
}

main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error(error);
    process.exit(1);
  });
